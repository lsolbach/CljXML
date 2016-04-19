[
 :module "CljXHtmlLibrary"
 :project "org.soulspace.clj"
 :type :library
 :version "0.2.1"
 :description "The CljXHtmlLibrary provides a DSL for the programmatic generation of XHtml files."
 :plugins [["org.soulspace.baumeister/ClojurePlugin"]
           ["org.soulspace.baumeister/ClojureTestPlugin"]
           ["org.soulspace.baumeister/PackagePlugin"]]
 :dependencies [["org.clojure/clojure, 1.7.0"]
                ["org.soulspace.clj/CljXmlLibrary, 0.4.2"]]
 ]
