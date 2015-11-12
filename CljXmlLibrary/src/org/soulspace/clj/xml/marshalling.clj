;
;   Copyright (c) Ludger Solbach. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file license.txt at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.
;
(ns org.soulspace.clj.xml.marshalling)

(defprotocol XMLMarshalling
  "Protocol for XML marshalling."
  (to-xml [this] "Produces xml as clojure.data.xml/Element structure that can be emitted with the fns from the clojure.data.xml namespace.")
  )

(defprotocol XMLUnmarshalling
  "Protocol for XML unmarshalling."
  ;? there's no element in the first place, install empty dummy usable as this in record or use a static factory function?
  (from-xml [this xml] "Unmarshals the given xml zipper into the record.")
  )
