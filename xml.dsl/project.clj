(defproject org.soulspace.clj/xml.dsl "0.5.3-SNAPSHOT"
  :description "The xml.dsl library contains a DSL builder for XML and DSLs for common some XML Dialects."
  :url "https://github.com/lsolbach/CljXML"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}

  ; use deps.edn dependencies
  :plugins [[lein-tools-deps "0.4.5"]]
  :middleware [lein-tools-deps.plugin/resolve-dependencies-with-deps-edn]
  :lein-tools-deps/config {:config-files [:install :user :project]}

;  :dependencies [[org.clojure/clojure "1.10.1"]
;                 [org.clojure/data.xml "0.0.8"]
;                 [org.soulspace.clj/clj.base "0.8.1"]]

:test-paths ["test"]
  :deploy-repositories [["clojars" {:sign-releases false :url "https://clojars.org/repo"}]])
