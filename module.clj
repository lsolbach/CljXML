[
 :module "CljBpmnLibrary"
 :project "org.soulspace.clj"
 :type :library
 :version "0.1.0"
 :description "The CljBpmnLibrary provides a DSL for the programmatic generation of BPMN 2.0 xml definitions."
 :plugins ["global" "dependencies" "clojure" "clojuretest" "package"]
 :dependencies [[["org.clojure" "clojure" "1.5.1"]]
                [["org.soulspace.clj" "CljXmlLibrary" "0.2.0"]]]
 ]
