(ns org.soulspace.clj.xsl.xsl-dsl
  (:refer-clojure :exclude [comment import key sort when])
  (:use [org.soulspace.clj.xml dsl-builder]))

; TODO XSL-1.0, check xsl elements here
(deftags "xsl"
  ["apply-imports" "apply-templates" "attribute" "attribute-set" "call-template"
   "choose" "comment" "copy" "copy-of" "decimal-format" "element" "fallback"
   "for-each" "if" "import" "include" "key" "message" "namespace-alias" "number"
   "otherwise" "output" "param" "preserve-space" "processing-instruction" "sort"
   "strip-space" "template" "text" "transform" "value-of" "variable" "when"
   "with-param"])

(defroottags "xsl" "http://www.w3.org/1999/XSL/Transform" ["stylesheet"])
