(defproject org.soulspace.clj/xml.dsl "0.5.2-SNAPSHOT"
  :description "The xml.dsl library contains a DSL builder for XML and DSLs for common some XML Dialects."
  :url "https://github.com/lsolbach/CljXML"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/data.xml "0.0.8"]
                 [org.soulspace.clj/clj.base "0.8.1"]]
  :test-paths ["unittest"]
  :deploy-repositories [["clojars" {:sign-releases false :url "https://clojars.org/repo"}]])
