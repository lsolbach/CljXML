;
;   Copyright (c) Ludger Solbach. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file license.txt at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.
;
(ns org.soulspace.clj.rdf.rdf-dsl
  (:use [org.soulspace.clj.xml dsl-builder]))

(deftags "rdf"
  ["about" "aboutEach" "aboutEachPrefix" "bagId" "datatype" "Description" "ID" "li" "nodeID" "parseType" "resource"])

(defroottags "rdf" "http://www.w3.org/1999/02/22-rdf-syntax-ns#"
  ["RDF"])
