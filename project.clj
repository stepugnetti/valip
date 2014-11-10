(defproject com.cemerick/valip "1.0.0"
  :description "Functional validation library for Clojure and ClojureScript, forked from https://github.com/weavejester/valip"
  :url "http://github.com/cemerick/valip"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2371"]]
  :plugins [[com.keminglabs/cljx "0.4.0"]]
  :hooks [cljx.hooks]
  :cljx {:builds [{:source-paths ["src/cljx"]
                   :output-path "target/clj"
                   :rules :clj}
                  {:source-paths ["src/cljx"]
                   :output-path "target/cljs"
                   :rules :cljs}]}
  :source-paths ["target/clj" "src/clj" "target/cljs" "src/cljs"]
  :profiles {:dev {:dependencies [[com.cemerick/clojurescript.test "0.3.1"]]
                   :hooks [leiningen.cljsbuild]
                   :plugins [[com.cemerick/clojurescript.test "0.3.1"]
                             [lein-cljsbuild "1.0.3"]]
                   :cljx {:builds [{:source-paths ["test/cljx"]
                                    :output-path "target/test/clj"
                                    :rules :clj}
                                   {:source-paths ["test/cljx"]
                                    :output-path "target/test/cljs"
                                    :rules :cljs}]}
                   :test-paths ["test/clj" "target/test/clj"]
                   :source-paths ["test/cljs" "target/test/cljs" "test/clj" "target/test/clj"]
                   :cljsbuild {:builds [{:source-paths ["target/cljs"]
                                         :compiler {:output-dir "target/classes"
                                                    :output-to "target/classes/valip.js"
                                                    :optimizations :advanced
                                                    :pretty-print false}}
                                        {:source-paths ["target/test/cljs"]
                                         :compiler {:output-dir "target/test-classes"
                                                    :output-to "target/test-classes/test_valip.js"
                                                    :optimization "whitespace"
                                                    :pretty-print false}}]

                               :test-commands {"unit-tests" ["phantomjs" :runner "target/test-classes/test_valip.js"]}}}})
