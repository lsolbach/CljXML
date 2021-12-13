XML Schema Observations
=======================

Named definitions
-----------------
Named definitions defined directly under the root element "schema" are global definitions.
Global definitions can be referenced from anywhere in the document.
Global named element definitions can be the root element of an instance document.

Named definitions defines in children of the root element "schema" are local definitions.
Local definitions can only be referenced in the context in which they are defined.
Local definitions shadow global definitions in the context in which they are defined.

Content Models and Content Types
--------------------------------
There are different content models for an element which exist independently from the existence of attributes in an element.
* Empty
* Simple
* Complex
* Mixed

Elements with a simple content model and no attributes are defined to be of simple type.
Elements with attributes and other content models are defined to be of complex type.

