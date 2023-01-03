package larva;


import main.MonitorFunctions;

import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_upload_monitor0 implements _callable{

public static PrintWriter pw; 
public static _cls_upload_monitor0 root;

public static LinkedHashMap<_cls_upload_monitor0,_cls_upload_monitor0> _cls_upload_monitor0_instances = new LinkedHashMap<_cls_upload_monitor0,_cls_upload_monitor0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\Mystech\\workspace\\BadLogin/src/output_upload_monitor.txt");

root = new _cls_upload_monitor0();
_cls_upload_monitor0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_upload_monitor0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public int postCount =0 ;
 public MonitorFunctions f =new MonitorFunctions ();

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_upload_monitor0() {
}

public void initialisation() {
}

public static _cls_upload_monitor0 _get_cls_upload_monitor0_inst() { synchronized(_cls_upload_monitor0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_upload_monitor0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_upload_monitor0_instances){
_performLogic_upload_prop(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_upload_monitor0[] a = new _cls_upload_monitor0[1];
synchronized(_cls_upload_monitor0_instances){
a = _cls_upload_monitor0_instances.keySet().toArray(a);}
for (_cls_upload_monitor0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_upload_monitor0_instances){
_cls_upload_monitor0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_upload_prop = 183;

public void _performLogic_upload_prop(String _info, int... _event) {

_cls_upload_monitor0.pw.println("[upload_prop]AUTOMATON::> upload_prop("+") STATE::>"+ _string_upload_prop(_state_id_upload_prop, 0));
_cls_upload_monitor0.pw.flush();

if (0==1){}
else if (_state_id_upload_prop==183){
		if (1==0){}
		else if ((_occurredEvent(_event,290/*scrape*/))){
		_cls_upload_monitor0.pw .println ("SCRAPED");

		_state_id_upload_prop = 180;//moving to state upload
		_goto_upload_prop(_info);
		}
}
else if (_state_id_upload_prop==182){
		if (1==0){}
		else if ((_occurredEvent(_event,294/*postAlert*/))){
		postCount ++;
_cls_upload_monitor0.pw .println ("POST "+postCount );

		_state_id_upload_prop = 181;//moving to state checkPost
		_goto_upload_prop(_info);
		}
		else if ((_occurredEvent(_event,296/*purgeAlerts*/)) && (postCount ==5 )){
		_cls_upload_monitor0.pw .println ("Attempted purge after "+postCount +" posts.");

		_state_id_upload_prop = 177;//moving to state purge
		_goto_upload_prop(_info);
		}
}
else if (_state_id_upload_prop==180){
		if (1==0){}
		else if ((_occurredEvent(_event,292/*uploadResults*/))){
		_cls_upload_monitor0.pw .println ("UPLOAD");
f .getLastEventType ();

		_state_id_upload_prop = 182;//moving to state post
		_goto_upload_prop(_info);
		}
}
else if (_state_id_upload_prop==181){
		if (1==0){}
		else if ((_occurredEvent(_event,298/*close*/)) && (f .getLastEventType ()==0 &&postCount <=5 )){
		
		_state_id_upload_prop = 182;//moving to state post
		_goto_upload_prop(_info);
		}
		else if ((_occurredEvent(_event,298/*close*/))){
		_cls_upload_monitor0.pw .println ("Bad Upload");

		_state_id_upload_prop = 179;//moving to state badUpload
		_goto_upload_prop(_info);
		}
}
}

public void _goto_upload_prop(String _info){
_cls_upload_monitor0.pw.println("[upload_prop]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_upload_prop(_state_id_upload_prop, 1));
_cls_upload_monitor0.pw.flush();
}

public String _string_upload_prop(int _state_id, int _mode){
switch(_state_id){
case 183: if (_mode == 0) return "scrape"; else return "scrape";
case 182: if (_mode == 0) return "post"; else return "post";
case 180: if (_mode == 0) return "upload"; else return "upload";
case 181: if (_mode == 0) return "checkPost"; else return "checkPost";
case 177: if (_mode == 0) return "purge"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  purge";
case 179: if (_mode == 0) return "badUpload"; else return "!!!SYSTEM REACHED BAD STATE!!! badUpload "+new _BadStateExceptionupload_monitor().toString()+" ";
case 178: if (_mode == 0) return "terminate"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  terminate";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}