[
 :module "xml.eclipse"
 :project "org.soulspace.clj"
 :type :library
 :version "0.2.0"
 :description "The xml.eclipse library contains code to handle Eclipse XML files."
 :project-lead "Ludger Solbach"
 :provider "soulspace.org"
 :license ["Eclipse Public License 1.0" "http://www.eclipse.org/legal/epl-v10.html"]
 :scm-url "https://github.com/lsolbach/CljDevTools"
 :plugins [["org.soulspace.baumeister/ClojurePlugin"]
           ["org.soulspace.baumeister/ClojureTestPlugin"]
           ["org.soulspace.baumeister/PackagePlugin"]]
 :dependencies [["org.clojure/clojure, 1.8.0"]
                ["org.clojure/data.zip, 0.1.1"]
                ["org.soulspace.clj/xml.core, 0.5.0"]
                ["org.soulspace.clj/xml.dsl, 0.5.0"]]]
