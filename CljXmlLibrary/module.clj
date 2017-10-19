[
 :module "CljXmlLibrary"
 :project "org.soulspace.clj"
 :type :library
 :version "0.4.3"
 :description "The CljXmlLibrary is a library for building XML DSLs in Clojure"
 :plugins [["org.soulspace.baumeister/ClojurePlugin"]
           ["org.soulspace.baumeister/ClojureTestPlugin"]
           ["org.soulspace.baumeister/PackagePlugin"]]
 :dependencies [["org.clojure/clojure, 1.8.0"]
                ["org.clojure/data.xml, 0.0.7"]
                ["org.soulspace.clj/CljLibrary, 0.7.0"]]
 ]