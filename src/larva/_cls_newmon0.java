package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_newmon0 implements _callable{

public static PrintWriter pw; 
public static _cls_newmon0 root;

public static LinkedHashMap<_cls_newmon0,_cls_newmon0> _cls_newmon0_instances = new LinkedHashMap<_cls_newmon0,_cls_newmon0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\Mystech\\workspace\\BadLogin/src/output_newmon.txt");

root = new _cls_newmon0();
_cls_newmon0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_newmon0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_newmon0() {
}

public void initialisation() {
}

public static _cls_newmon0 _get_cls_newmon0_inst() { synchronized(_cls_newmon0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_newmon0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_newmon0_instances){
_performLogic_thingprop(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_newmon0[] a = new _cls_newmon0[1];
synchronized(_cls_newmon0_instances){
a = _cls_newmon0_instances.keySet().toArray(a);}
for (_cls_newmon0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_newmon0_instances){
_cls_newmon0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_thingprop = 62;

public void _performLogic_thingprop(String _info, int... _event) {

_cls_newmon0.pw.println("[thingprop]AUTOMATON::> thingprop("+") STATE::>"+ _string_thingprop(_state_id_thingprop, 0));
_cls_newmon0.pw.flush();

if (0==1){}
else if (_state_id_thingprop==62){
		if (1==0){}
		else if ((_occurredEvent(_event,100/*scrape*/))){
		_cls_newmon0.pw .println ("SCRAPED");

		_state_id_thingprop = 61;//moving to state upload
		_goto_thingprop(_info);
		}
}
}

public void _goto_thingprop(String _info){
_cls_newmon0.pw.println("[thingprop]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_thingprop(_state_id_thingprop, 1));
_cls_newmon0.pw.flush();
}

public String _string_thingprop(int _state_id, int _mode){
switch(_state_id){
case 62: if (_mode == 0) return "scrape"; else return "scrape";
case 61: if (_mode == 0) return "upload"; else return "upload";
case 60: if (_mode == 0) return "crash"; else return "!!!SYSTEM REACHED BAD STATE!!! crash "+new _BadStateExceptionnewmon().toString()+" ";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}