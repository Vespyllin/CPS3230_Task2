package aspects;

import main.MonitorFunctions;

import larva.*;
public aspect _asp_website_monitor0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_website_monitor0.initialize();
}
}
before () : (call(* *.login(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_website_monitor0.lock){

_cls_website_monitor0 _cls_inst = _cls_website_monitor0._get_cls_website_monitor0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 334/*login*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 334/*login*/);
}
}
before () : (call(* *.goToSite(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_website_monitor0.lock){

_cls_website_monitor0 _cls_inst = _cls_website_monitor0._get_cls_website_monitor0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 330/*goToSite*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 330/*goToSite*/);
}
}
before () : (call(* *.goToAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_website_monitor0.lock){

_cls_website_monitor0 _cls_inst = _cls_website_monitor0._get_cls_website_monitor0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 332/*goToAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 332/*goToAlerts*/);
}
}
before () : (call(* *.teardown(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_website_monitor0.lock){

_cls_website_monitor0 _cls_inst = _cls_website_monitor0._get_cls_website_monitor0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 338/*teardown*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 338/*teardown*/);
}
}
before () : (call(* *.logout(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_website_monitor0.lock){

_cls_website_monitor0 _cls_inst = _cls_website_monitor0._get_cls_website_monitor0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 336/*logout*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 336/*logout*/);
}
}
}