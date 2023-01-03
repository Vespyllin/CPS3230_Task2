package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_test_monitor0 implements _callable{

public static PrintWriter pw; 
public static _cls_test_monitor0 root;

public static LinkedHashMap<_cls_test_monitor0,_cls_test_monitor0> _cls_test_monitor0_instances = new LinkedHashMap<_cls_test_monitor0,_cls_test_monitor0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\Mystech\\workspace\\BadLogin/src/output_test_monitor.txt");

root = new _cls_test_monitor0();
_cls_test_monitor0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_test_monitor0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public int i =0 ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_test_monitor0() {
}

public void initialisation() {
}

public static _cls_test_monitor0 _get_cls_test_monitor0_inst() { synchronized(_cls_test_monitor0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_test_monitor0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_test_monitor0_instances){
_performLogic_test_prop(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_test_monitor0[] a = new _cls_test_monitor0[1];
synchronized(_cls_test_monitor0_instances){
a = _cls_test_monitor0_instances.keySet().toArray(a);}
for (_cls_test_monitor0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_test_monitor0_instances){
_cls_test_monitor0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_test_prop = 239;

public void _performLogic_test_prop(String _info, int... _event) {

_cls_test_monitor0.pw.println("[test_prop]AUTOMATON::> test_prop("+") STATE::>"+ _string_test_prop(_state_id_test_prop, 0));
_cls_test_monitor0.pw.flush();

if (0==1){}
else if (_state_id_test_prop==238){
		if (1==0){}
		else if ((_occurredEvent(_event,384/*inc*/))){
		i +=1 ;
_cls_test_monitor0.pw .println ("inc "+i );

		_state_id_test_prop = 238;//moving to state normalstate
		_goto_test_prop(_info);
		}
}
else if (_state_id_test_prop==239){
		if (1==0){}
		else if ((_occurredEvent(_event,384/*inc*/))){
		i +=1 ;
_cls_test_monitor0.pw .println ("inc "+i );

		_state_id_test_prop = 238;//moving to state normalstate
		_goto_test_prop(_info);
		}
}
}

public void _goto_test_prop(String _info){
_cls_test_monitor0.pw.println("[test_prop]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_test_prop(_state_id_test_prop, 1));
_cls_test_monitor0.pw.flush();
}

public String _string_test_prop(int _state_id, int _mode){
switch(_state_id){
case 238: if (_mode == 0) return "normalstate"; else return "normalstate";
case 239: if (_mode == 0) return "_normalstate"; else return "_normalstate";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}