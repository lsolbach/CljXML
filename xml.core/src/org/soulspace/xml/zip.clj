;
;   Copyright (c) Ludger Solbach. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file license.txt at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.
;
(ns org.soulspace.xml.zip
  (:require [clojure.zip :as zip]
            [clojure.data.xml :as xml]
            [clojure.java.io :as io]))

(defmulti xml-zipper class)

(defmethod xml-zipper java.io.File [file]
  (with-open [rdr (io/reader file)]
    (zip/xml-zip (xml/parse-str (slurp rdr)))))

; TODO implement more robust URL loading (clj-base)? 
(defmethod xml-zipper java.net.URL [url]
  (with-open [rdr (io/reader url)]
    (zip/xml-zip (xml/parse-str (slurp rdr)))))

(defmethod xml-zipper String [str]
  (cond
    (.startsWith str "<") (zip/xml-zip (xml/parse-str str)) ; handle as xml string
    (.startsWith str "http") (xml-zipper (as-url str)) ; handle as url
    :default (xml-zipper (as-file str)))) ; handle as file name

(defn current-zipper-tag
  "Returns the tag keyword of the current zipper element."
  [zipper]
  (:tag (first zipper)))
