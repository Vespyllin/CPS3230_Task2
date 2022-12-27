package larva;


import main.ApiHandler;
import main.EventTrace;

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
 public ApiHandler apiHandler =new ApiHandler ();
 public EventTrace[] traces ;
 public EventTrace lastTrace ;

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
_performLogic_thingprop(_info, _event);
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

int _state_id_thingprop = 108;

public void _performLogic_thingprop(String _info, int... _event) {

_cls_website_monitor0.pw.println("[thingprop]AUTOMATON::> thingprop("+") STATE::>"+ _string_thingprop(_state_id_thingprop, 0));
_cls_website_monitor0.pw.flush();

if (0==1){}
else if (_state_id_thingprop==108){
		if (1==0){}
		else if ((_occurredEvent(_event,170/*goToSite*/))){
		_cls_website_monitor0.pw .println ("Navigating to site");

		_state_id_thingprop = 105;//moving to state loggedOut
		_goto_thingprop(_info);
		}
}
else if (_state_id_thingprop==106){
		if (1==0){}
		else if ((_occurredEvent(_event,172/*goToAlerts*/)) && (lastTrace .eventLogType ==5 )){
		traces =apiHandler .getTraces ();
lastTrace =traces [traces .length -1 ];
_cls_website_monitor0.pw .println ("Navigating to Alerts");

		_state_id_thingprop = 107;//moving to state atAlerts
		_goto_thingprop(_info);
		}
}
else if (_state_id_thingprop==105){
		if (1==0){}
		else if ((_occurredEvent(_event,174/*login*/))){
		traces =apiHandler .getTraces ();
lastTrace =traces [traces .length -1 ];
_cls_website_monitor0.pw .println ("Login");

		_state_id_thingprop = 106;//moving to state loggedIn
		_goto_thingprop(_info);
		}
		else if ((_occurredEvent(_event,178/*teardown*/)) && (lastTrace !=null &&lastTrace .eventLogType ==6 )){
		_cls_website_monitor0.pw .println ("Teardown");

		_state_id_thingprop = 104;//moving to state cleanup
		_goto_thingprop(_info);
		}
}
else if (_state_id_thingprop==107){
		if (1==0){}
		else if ((_occurredEvent(_event,176/*logout*/)) && (lastTrace !=null &&lastTrace .eventLogType ==7 )){
		traces =apiHandler .getTraces ();
lastTrace =traces .length ==0 ?null :traces [traces .length -1 ];
_cls_website_monitor0.pw .println ("Logout");

		_state_id_thingprop = 105;//moving to state loggedOut
		_goto_thingprop(_info);
		}
}
}

public void _goto_thingprop(String _info){
_cls_website_monitor0.pw.println("[thingprop]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_thingprop(_state_id_thingprop, 1));
_cls_website_monitor0.pw.flush();
}

public String _string_thingprop(int _state_id, int _mode){
switch(_state_id){
case 103: if (_mode == 0) return "exit"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  exit";
case 108: if (_mode == 0) return "init"; else return "init";
case 104: if (_mode == 0) return "cleanup"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  cleanup";
case 106: if (_mode == 0) return "loggedIn"; else return "loggedIn";
case 105: if (_mode == 0) return "loggedOut"; else return "loggedOut";
case 107: if (_mode == 0) return "atAlerts"; else return "atAlerts";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}