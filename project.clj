(defproject com.cemerick/valip "1.0.0"
  :description "Functional validation library for Clojure and ClojureScript, forked from https://github.com/weavejester/valip"
  :url "http://github.com/cemerick/valip"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2371"]]
  :plugins [[lein-cljsbuild "1.0.3"]
            [com.keminglabs/cljx "0.4.0"]]
  :hooks [leiningen.cljsbuild]
  :cljx {:builds [{:source-paths ["src/cljx"]
                   :output-path "src/clj"
                   :rules :clj}
                  {:source-paths ["src/cljx"]
                   :output-path "src/cljs"
                   :rules :cljs}]}
  :source-paths ["src/clj" "src/cljs"]
  :cljsbuild {:builds [{:source-paths ["src/clj" "src/cljs"]
                        :compiler {:output-dir ".cljsbuild/valip"
                                   :output-to "public/valip.js"
                                   :optimizations :advanced
                                   :pretty-print false}}]}
  :profiles {:dev {:dependencies [[com.cemerick/clojurescript.test "0.3.1"]]
                   :plugins [[com.cemerick/clojurescript.test "0.3.1"]]
                   :cljx {:builds [{:source-paths ["test/cljx"]
                                    :output-path "test/clj"
                                    :rules :clj}
                                   {:source-paths ["test/cljx"]
                                    :output-path "test/cljs"
                                    :rules :cljs}]}
                   :test-paths ["test/clj"]
                   :source-paths ["test/cljs" "test/clj"]
                   :cljsbuild {:builds [{:source-paths ["test/cljs"]
                                         :compiler {:source-paths ["test/cljs"]
                                                    :optimization "whitespace"
                                                    :output-dir ".cljsbuild/valip/test"
                                                    :output-to "test/test_valip.js"}}]

                               :test-commands {"unit-tests" ["phantomjs" :runner "test/test_valip.js"]}}}})
