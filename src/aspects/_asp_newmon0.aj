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
_cls_inst._call(thisJoinPoint.getSignature().toString(), 244/*postAlert*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 244/*postAlert*/);
}
}
before () : (call(* *.uploadResults(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_newmon0.lock){

_cls_newmon0 _cls_inst = _cls_newmon0._get_cls_newmon0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 242/*uploadResults*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 242/*uploadResults*/);
}
}
before () : (call(* *.purgeAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_newmon0.lock){

_cls_newmon0 _cls_inst = _cls_newmon0._get_cls_newmon0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 246/*purgeAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 246/*purgeAlerts*/);
}
}
before () : (call(* *.scrape(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_newmon0.lock){

_cls_newmon0 _cls_inst = _cls_newmon0._get_cls_newmon0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 240/*scrape*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 240/*scrape*/);
}
}
}