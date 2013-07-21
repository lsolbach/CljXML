(ns org.soulspace.clj.xhtml.xhtml5-dsl
  (:refer-clojure :exclude [map meta])
  (:use [org.soulspace.clj.xml dsl-builder]))

; HTML5 according to Candidate Recommendation: http://www.w3.org/TR/html5/
(deftags "xhtml5"
  ["a" "abbr" "address" "area" "article" "aside" "audio" "b" "base" "bdi"
   "bdo" "blockquote" "body" "br" "button" "canvas" "caption" "cite" "code"
   "col" "colgroup" "command" "data" "datalist" "dd" "del" "details" "dfn"
   "dialog" "div" "dl" "dt" "em" "embed" "fieldset" "figcaption" "figure"
   "footer" "form" "h1" "h2" "h3" "h4" "h5" "h6" "head" "header" "hgroup"
   "hr" "i" "iframe" "img" "input" "ins" "kbd" "keygen" "label" "legend"
   "li" "link" "map" "mark" "menu" "meta" "meter" "nav" "noscript" "object"
   "ol" "optgroup" "option" "output" "p" "param" "pre" "progress" "q" "rp"
   "rt" "ruby" "s" "samp" "script" "section" "select" "small" "source" "span"
   "strong" "style" "sub" "summary" "sup" "table" "tbody" "td" "textarea"
   "tfoot" "th" "thead" "time" "title" "tr" "track" "u" "ul" "var" "video"
   "wbr"
   ])

(defrootags "xhtml5" "http://www.w3.org/1999/xhtml" ["html"])