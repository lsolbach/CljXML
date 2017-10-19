[
 :module "CljMathmlLibrary"
 :project "org.soulspace.clj"
 :type :library
 :version "0.1.2"
 :description "The CljMathmlLibrary provides a DSL for the programmatic generation of MathML XML files"
 :plugins [["org.soulspace.baumeister/ClojurePlugin"]
           ["org.soulspace.baumeister/ClojureTestPlugin"]
           ["org.soulspace.baumeister/PackagePlugin"]]
 :dependencies [["org.clojure/clojure, 1.8.0"]
                ["org.soulspace.clj/CljXmlLibrary, 0.4.3"]]
 ]
