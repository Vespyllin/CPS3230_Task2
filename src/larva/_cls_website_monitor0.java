package larva;


import main.MonitorFunctions;

import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_website_monitor0 implements _callable{

public static PrintWriter pw; 
public static _cls_website_monitor0 root;

public static LinkedHashMap<_cls_website_monitor0,_cls_website_monitor0> _cls_website_monitor0_instances = new LinkedHashMap<_cls_website_monitor0,_cls_website_monitor0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\Mystech\\workspace\\BadLogin/src/output_website_monitor.txt");

root = new _cls_website_monitor0();
_cls_website_monitor0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_website_monitor0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public MonitorFunctions f =new MonitorFunctions ();

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_website_monitor0() {
}

public void initialisation() {
}

public static _cls_website_monitor0 _get_cls_website_monitor0_inst() { synchronized(_cls_website_monitor0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_website_monitor0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_website_monitor0_instances){
_performLogic_website_prop(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_website_monitor0[] a = new _cls_website_monitor0[1];
synchronized(_cls_website_monitor0_instances){
a = _cls_website_monitor0_instances.keySet().toArray(a);}
for (_cls_website_monitor0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_website_monitor0_instances){
_cls_website_monitor0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_website_prop = 189;

public void _performLogic_website_prop(String _info, int... _event) {

_cls_website_monitor0.pw.println("[website_prop]AUTOMATON::> website_prop("+") STATE::>"+ _string_website_prop(_state_id_website_prop, 0));
_cls_website_monitor0.pw.flush();

if (0==1){}
else if (_state_id_website_prop==189){
		if (1==0){}
		else if ((_occurredEvent(_event,300/*goToSite*/))){
		f .getLastEventType ();
_cls_website_monitor0.pw .println ("Navigating to site");

		_state_id_website_prop = 186;//moving to state loggedOut
		_goto_website_prop(_info);
		}
}
else if (_state_id_website_prop==187){
		if (1==0){}
		else if ((_occurredEvent(_event,302/*goToAlerts*/)) && (f .getLastEventType ()==5 )){
		_cls_website_monitor0.pw .println ("Viewed alerts");

		_state_id_website_prop = 188;//moving to state atAlerts
		_goto_website_prop(_info);
		}
		else if ((_occurredEvent(_event,302/*goToAlerts*/))){
		_cls_website_monitor0.pw .println ("INVALID LOGIN");

		_state_id_website_prop = 188;//moving to state atAlerts
		_goto_website_prop(_info);
		}
}
else if (_state_id_website_prop==186){
		if (1==0){}
		else if ((_occurredEvent(_event,304/*login*/))){
		_cls_website_monitor0.pw .println ("Login");

		_state_id_website_prop = 187;//moving to state loggedIn
		_goto_website_prop(_info);
		}
		else if ((_occurredEvent(_event,308/*teardown*/)) && (f .getLastEventType ()==6 )){
		_cls_website_monitor0.pw .println ("Teardown");

		_state_id_website_prop = 185;//moving to state cleanup
		_goto_website_prop(_info);
		}
}
else if (_state_id_website_prop==188){
		if (1==0){}
		else if ((_occurredEvent(_event,306/*logout*/)) && (f .getLastEventType ()==7 )){
		_cls_website_monitor0.pw .println ("Logout");

		_state_id_website_prop = 186;//moving to state loggedOut
		_goto_website_prop(_info);
		}
}
}

public void _goto_website_prop(String _info){
_cls_website_monitor0.pw.println("[website_prop]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_website_prop(_state_id_website_prop, 1));
_cls_website_monitor0.pw.flush();
}

public String _string_website_prop(int _state_id, int _mode){
switch(_state_id){
case 184: if (_mode == 0) return "exit"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  exit";
case 189: if (_mode == 0) return "init"; else return "init";
case 185: if (_mode == 0) return "cleanup"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  cleanup";
case 187: if (_mode == 0) return "loggedIn"; else return "loggedIn";
case 186: if (_mode == 0) return "loggedOut"; else return "loggedOut";
case 188: if (_mode == 0) return "atAlerts"; else return "atAlerts";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}