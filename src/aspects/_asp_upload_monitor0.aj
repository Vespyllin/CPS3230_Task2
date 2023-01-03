package aspects;

import main.MonitorFunctions;

import larva.*;
public aspect _asp_upload_monitor0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_upload_monitor0.initialize();
}
}
before () : (call(* *.postAlert(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_upload_monitor0.lock){

_cls_upload_monitor0 _cls_inst = _cls_upload_monitor0._get_cls_upload_monitor0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 324/*postAlert*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 324/*postAlert*/);
}
}
before () : (call(* *.close(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_upload_monitor0.lock){

_cls_upload_monitor0 _cls_inst = _cls_upload_monitor0._get_cls_upload_monitor0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 328/*close*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 328/*close*/);
}
}
before () : (call(* *.uploadResults(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_upload_monitor0.lock){

_cls_upload_monitor0 _cls_inst = _cls_upload_monitor0._get_cls_upload_monitor0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 322/*uploadResults*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 322/*uploadResults*/);
}
}
before () : (call(* *.purgeAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_upload_monitor0.lock){

_cls_upload_monitor0 _cls_inst = _cls_upload_monitor0._get_cls_upload_monitor0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 326/*purgeAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 326/*purgeAlerts*/);
}
}
before () : (call(* *.scrape(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_upload_monitor0.lock){

_cls_upload_monitor0 _cls_inst = _cls_upload_monitor0._get_cls_upload_monitor0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 320/*scrape*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 320/*scrape*/);
}
}
}