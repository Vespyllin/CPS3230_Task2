package larva;


import main.ApiHandler;
import main.EventTrace;
import java.time.LocalDateTime;

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
 public int confirmedAlertCount =0 ;
 public ApiHandler apiHandler =new ApiHandler ();
 public EventTrace[] traces ;
 public EventTrace lastTrace =null ;

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
_performLogic_thingprop(_info, _event);
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

int _state_id_thingprop = 522;

public void _performLogic_thingprop(String _info, int... _event) {

_cls_upload_monitor0.pw.println("[thingprop]AUTOMATON::> thingprop("+") STATE::>"+ _string_thingprop(_state_id_thingprop, 0));
_cls_upload_monitor0.pw.flush();

if (0==1){}
else if (_state_id_thingprop==522){
		if (1==0){}
		else if ((_occurredEvent(_event,700/*scrape*/))){
		_cls_upload_monitor0.pw .println ("SCRAPED");

		_state_id_thingprop = 519;//moving to state upload
		_goto_thingprop(_info);
		}
}
else if (_state_id_thingprop==521){
		if (1==0){}
		else if ((_occurredEvent(_event,704/*postAlert*/)) && (postCount <5 &&postCount ==confirmedAlertCount )){
		postCount ++;
_cls_upload_monitor0.pw .println ("POST "+postCount );

		_state_id_thingprop = 520;//moving to state checkPost
		_goto_thingprop(_info);
		}
		else if ((_occurredEvent(_event,704/*postAlert*/))){
		postCount ++;
_cls_upload_monitor0.pw .println ("INVALID STATE: Attempted to post "+postCount +"times, "+confirmedAlertCount +" received.");

		_state_id_thingprop = 517;//moving to state badUpload
		_goto_thingprop(_info);
		}
		else if ((_occurredEvent(_event,706/*purgeAlerts*/)) && (postCount ==5 &&postCount ==confirmedAlertCount )){
		_cls_upload_monitor0.pw .println ("Attempted purge after "+postCount +" posts.");

		_state_id_thingprop = 518;//moving to state purge
		_goto_thingprop(_info);
		}
}
else if (_state_id_thingprop==519){
		if (1==0){}
		else if ((_occurredEvent(_event,702/*uploadResults*/))){
		_cls_upload_monitor0.pw .println ("UPLOAD");

		_state_id_thingprop = 521;//moving to state post
		_goto_thingprop(_info);
		}
}
else if (_state_id_thingprop==520){
		if (1==0){}
		else if ((_occurredEvent(_event,708/*close*/))){
		traces =apiHandler .getTraces ();
lastTrace =traces [traces .length -1 ];
confirmedAlertCount =lastTrace .systemState .alerts .length ;

		_state_id_thingprop = 521;//moving to state post
		_goto_thingprop(_info);
		}
}
}

public void _goto_thingprop(String _info){
_cls_upload_monitor0.pw.println("[thingprop]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_thingprop(_state_id_thingprop, 1));
_cls_upload_monitor0.pw.flush();
}

public String _string_thingprop(int _state_id, int _mode){
switch(_state_id){
case 515: if (_mode == 0) return "acceptableUpload"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  acceptableUpload";
case 522: if (_mode == 0) return "scrape"; else return "scrape";
case 521: if (_mode == 0) return "post"; else return "post";
case 519: if (_mode == 0) return "upload"; else return "upload";
case 520: if (_mode == 0) return "checkPost"; else return "checkPost";
case 517: if (_mode == 0) return "badUpload"; else return "!!!SYSTEM REACHED BAD STATE!!! badUpload "+new _BadStateExceptionupload_monitor().toString()+" ";
case 518: if (_mode == 0) return "purge"; else return "purge";
case 516: if (_mode == 0) return "terminate"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  terminate";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}