(ns org.soulspace.clj.xml.xhtml
  (:refer-clojure :exclude [map meta])
  (:use [org.soulspace.clj.xml xml]))

(deftags "xhtml"
  ["a" "abbr" "acronym" "address" "area" "b" "base" "bdo" "big" "blockquote" "body" "br" "button" "caption"
   "cite" "code" "col" "colgroup" "dd" "del" "dfn" "div" "dl" "dt" "em" "fieldset" "form" "frame" "frameset"
   "h1" "h2" "h3" "h4" "h5" "h6" "head" "hr" "i" "iframe" "img" "input" "ins" "insert" "kbd" "label" "legend" "li"
   "link" "map" "meta" "noframes" "noscript" "object" "ol" "optgroup" "option" "p" "param" "pre" "q" "samp"
   "script" "select" "small" "span" "strong" "style" "sub" "sup" "table" "tbody" "td" "textarea" "tfoot" "th" "thead"
   "title" "tr" "tt" "u" "ul" "var"])

(defroottags "xhtml" "http://www.w3.org/1999/xhtml" ["html"])
