(ns valip.js.predicates
  "Useful validation predicates implemented for ClojureScript using the Google Closure libraries
where necessary."
  (:import goog.Uri))

(defn url?
  [s]
  (let [uri (-> s goog.Uri/parse)]
    (and (seq (.getScheme uri))
         (seq (.getSchemeSpecificPart uri))
         (re-find #"//" s))))