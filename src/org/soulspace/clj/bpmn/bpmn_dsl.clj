(ns org.soulspace.clj.bpmn.bpmn-dsl
  (:use [org.soulspace.clj.xml xml]))

(deftags "bpmn"
  ["adHocSubProcess" "assignment" "boundaryEvent" "businessRuleTask" "cancelEventDefinition"
   "compensateEventDefinition" "conditionalEventDefinition" "dataInput"
   "dataInputAssociation" "dataObject" "dataOutput" "dataOutputAssociation" "definitions"
   "endEvent" "error" "errorEventDefinition" "escalation" "escalationEventDefinition"
   "eventBasedGateway" "exclusiveGateway" "formalExpression" "inclusiveGateway" "inputSet"
   "interface" "intermediateCatchEvent" "intermediateThrowEvent" "ioSpecification"
   "itemDefinition" "lane laneSet" "manualTask" "message" "messageEventDefinition"
   "multiInstanceLoopCharacteristics" "operation" "outputSet" "parallelGateway"
   "potentialOwner" "process" "property" "receiveTask" "resourceAssignmentExpression" "script"
   "scriptTask" "sendTask" "serviceTask" "sequenceFlow" "signalEventDefinition" "startEvent"
   "subProcess" "task" "terminateEventDefinition" "timerEventDefinition" "userTask"])

(defroottags "bpmn" "http://www.omg.org/spec/BPMN/20100524/MODEL" ["definitions"])

(deftags "bpmndi"
  ["Bounds" "BPMNDI" "BPMNDiagram" "BPMNEdge" "BPMNPlane" "BPMNShape" "waypoint"])

(defroottags "bpmndi" "http://www.omg.org/spec/BPMN/20100524/DI" ["BPMNDI"])

(deftags "dc" ["Bounds"])
(deftags "di" ["waypoint"])

;xmlns:dc="http://www.omg.org/spec/DD/20100524/DC"
;xmlns:di="http://www.omg.org/spec/DD/20100524/DI"