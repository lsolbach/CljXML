;
;   Copyright (c) Ludger Solbach. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file license.txt at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.
;
(ns org.soulspace.clj.bpmn.bpmn-dsl
  (:use [org.soulspace.clj.xml dsl-builder]))

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