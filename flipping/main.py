import random
import _thread
import time

from kivy.app import App
from kivy.lang.builder import Builder
from kivy.properties import BooleanProperty, NumericProperty, ObjectProperty
from kivy.uix.behaviors import FocusBehavior
from kivy.uix.boxlayout import BoxLayout
from kivy.uix.label import Label
from kivy.uix.popup import Popup
from kivy.graphics import Rectangle
from kivy.uix.recyclegridlayout import RecycleGridLayout
from kivy.uix.recycleview import RecycleView
from kivy.uix.recycleview.layout import LayoutSelectionBehavior
from kivy.uix.recycleview.views import RecycleDataViewBehavior
from kivy.core.window import Window

__version__="1.0.0"

Builder.load_string("""
<SelectableCard>:
    canvas.before:
        Color:
            rgba:
                (1,0,0,1) if self.mode==0 \
                else (0,1,0,1) if self.mode==1 \
                else (0,0,1,1) if self.mode==2 \
                else (0,0,0,0)
        Ellipse:
            size:self.size
            pos:self.pos
    canvas.after:
        Color:
            rgba: 
                (0,0,0,1) if not self.selectable \
                else (1,1,1,.1) if self.selected \
                else (.2,.5,.5,1)
        Rectangle:
            pos:self.pos
            size:self.size
    font_size:sp(50)
<RV>:
    layout:gridlayout
    viewclass:"SelectableCard"
    SelectableRecycleGridLayout:
        id:gridlayout
        default_size:dp(60),dp(60)
        default_size_hint:None,None
        size_hint_y:None
        height:self.minimum_height
        cols:4
        spacing:10
        multiselect:True
        touch_multiselect:True
<TurnOver>:
    orientation:"vertical"
    BoxLayout:
        orientation:"horizontal"
        size_hint_y:None
        height:sp(100)
        Button:
            text:"New"
            font_size:sp(20)
            size_hint_x:None
            width:sp(100)
            on_press:
                rv.layout.count=0
                rv.new_game()
        Label:
            text:str(rv.layout.count)
            font_size:sp(20)
    BoxLayout:
        orientation:"horizontal"
        Label:
        Label:
        RV:
            id:rv
            size_hint_x:None
            width:sp(400)
        Label:
""")

class Finished(Popup):
    def __init__(self,**kwargs):
        super(Finished,self).__init__(**kwargs)
        self.auto_dismiss=True

#Cards that can be flipped
class SelectableCard(RecycleDataViewBehavior,Label):
    index=None
    mode=NumericProperty(0)
    selected=BooleanProperty(False)
    selectable=BooleanProperty(True)

    def refresh_view_attrs(self,rv,index,data):
        self.index=index
        return super(SelectableCard,self).refresh_view_attrs(rv,index,data)
    
    def on_touch_down(self,touch):
        if super(SelectableCard,self).on_touch_down(touch):
            return True
        if (self.collide_point(*touch.pos)) and (self.selectable):
            return self.parent.select_with_touch(self.index,touch)
    
    def apply_selection(self,rv,index,is_selected):
        self.selected=is_selected

class SelectableRecycleGridLayout(FocusBehavior,LayoutSelectionBehavior,RecycleGridLayout):
    count=NumericProperty(0)

    def select_with_touch(self,index,touch):
        super(SelectableRecycleGridLayout,self).select_with_touch(index,touch)
        if len(self.selected_nodes)>1:
            self.count+=1
            _thread.start_new_thread(self.check_selected_cards,())

    def check_selected_cards(self):
        a=self.selected_nodes[0]
        b=self.selected_nodes[1]
        if(self.parent.data[a]['mode']==self.parent.data[b]['mode']) and (self.parent.data[a]['text']==self.parent.data[b]['text']):
            self.parent.data[a]['mode']=3
            self.parent.data[b]['mode']=3
            self.parent.data[a]['selectable']=False
            self.parent.data[b]['selectable']=False
            self.parent.refresh_from_data()
        time.sleep(.3)
        self.clear_selection()
        #check if all cards is unselectable
        for i in self.parent.data:
            if i["selectable"]:
                return
        popup=Finished(title="Score:"+str(self.count),size_hint=(.8,.2))
        popup.content=Label(text="Press New to start the next game")
        popup.open()
        self.cout=0
        self.parent.new_game()

class RV(RecycleView):
    layout=ObjectProperty(None)

    def __init__(self,**kwargs):
        super(RV,self).__init__(**kwargs)
        self.new_game()

    def new_game(self):
        if len(self.data)!=0:
            self.data.clear()
        #text:number mode:color selectable:can be select selected:selected or not
        for i in range(8):
            self.data.append({"text":str(i),"mode":i%3,"selectable":True,"selected":True})
            self.data.append({"text":str(i),"mode":i%3,"selectable":True,"selected":True})
        random.shuffle(self.data)
        self.refresh_from_data()
        self.open_all()

    def open_all(self):
        _thread.start_new_thread(self.select_all, ())

    def select_all(self):
        for i in range(16):
            self.layout.select_node(i)
        time.sleep(1)
        self.layout.clear_selection()

class TurnOver(BoxLayout):
    pass

class TurnOverApp(App):
    def build(self):
        return TurnOver()

if __name__=="__main__":
    TurnOverApp().run()
