(defproject org.soulspace.clj/xml.svg "0.2.0"
  :description "The CljSvgLibrary provides a DSL for the programmatic generation of MathML XML files"
  :url "https://github.com/lsolbach/CljXML"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.apache.xmlgraphics/batik-swing "1.9.1"]
                 [org.apache.xmlgraphics/batik-svggen "1.9.1"]
                 [org.apache.xmlgraphics/batik-svg-dom "1.9.1"]
                 [org.soulspace.clj/xml.core "0.5.0"]
                 [org.soulspace.clj/clj.base "0.8.0"]]
  :test-paths ["unittest"])
