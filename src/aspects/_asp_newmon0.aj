package aspects;

import larva.*;
public aspect _asp_newmon0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_newmon0.initialize();
}
}
before () : (call(* *.postAlert(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_newmon0.lock){

_cls_newmon0 _cls_inst = _cls_newmon0._get_cls_newmon0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 236/*postAlert*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 236/*postAlert*/);
}
}
before () : (call(* *.uploadResults(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_newmon0.lock){

_cls_newmon0 _cls_inst = _cls_newmon0._get_cls_newmon0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 234/*uploadResults*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 234/*uploadResults*/);
}
}
before () : (call(* *.purgeAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_newmon0.lock){

_cls_newmon0 _cls_inst = _cls_newmon0._get_cls_newmon0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 238/*purgeAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 238/*purgeAlerts*/);
}
}
before () : (call(* *.scrape(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_newmon0.lock){

_cls_newmon0 _cls_inst = _cls_newmon0._get_cls_newmon0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 232/*scrape*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 232/*scrape*/);
}
}
}