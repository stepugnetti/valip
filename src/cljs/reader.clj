(ns cljs.reader
  "A dummy namespace, allowing valip.predicate to :require cljs.reader even in Clojure,
so as to allow portable usage of `read-string`.")

(def read-string clojure.core/read-string)