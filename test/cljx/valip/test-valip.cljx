(ns valip.test-valip
  #+clj (:require [clojure.test :refer :all])
  #+cljs (:require-macros [cemerick.cljs.test :refer [deftest testing is]])
  #+cljs (:require [cemerick.cljs.test]))

(deftest test-foo
  (testing "Testing the dummy function."
    (is true)))
