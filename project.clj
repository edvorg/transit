(defproject rocks.clj/transit "0.1.0-SNAPSHOT"
  :description ""
  :url "https://github.com/edvorg/transit"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.9.908" :scope "provided"]
                 [com.cognitect/transit-clj "0.8.300"]
                 [com.cognitect/transit-cljs "0.8.243"]]
  :plugins [[lein-cljsbuild "1.1.7"]]
  :clean-targets ^{:protect false} [:target-path
                                    [:cljsbuild :builds :app :compiler :output-dir]
                                    [:cljsbuild :builds :app :compiler :output-to]]
  :test-paths ["test/cljc"]
  :source-paths ["src/cljc"]
  :cljsbuild {:builds {:minify {:source-paths ["src/cljc"]
                                :compiler {:optimizations :advanced
                                           :pretty-print  false}}
                       :dev {:source-paths ["src/cljc"]
                             :compiler {:optimizations :none}}}}
  :javac-options ["-target" "1.7" "-source" "1.7" "-Xlint:-options"])
