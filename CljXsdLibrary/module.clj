[
 :module "CljXsdLibrary"
 :project "org.soulspace.clj"
 :type :library
 :version "0.1.2"
 :description "The CljXsdLibrary provides a DSL for the programmatic generation of XML Schema files"
 :plugins [["org.soulspace.baumeister/ClojurePlugin"]
           ["org.soulspace.baumeister/ClojureTestPlugin"]
           ["org.soulspace.baumeister/PackagePlugin"]]
 :dependencies [["org.clojure/clojure, 1.8.0"]
                ["org.soulspace.clj/CljXmlLibrary, 0.4.3"]]
 ]
