(defproject modern-cljs "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/clojurescript "1.11.60"]]
  :source-paths ["src/clj" "src/cljs"]
  ;; lein-cljsbuild plugin to build a CLJS project  
  :plugins [[lein-cljsbuild "1.1.8"]
            [lein-ring "0.12.6"]
            [compojure "1.7.0"]]
  ;; ring
  :ring {:handler modern-cljs.core/handler}
  ;; cljsbuild options configuration
  :cljsbuild {:builds [{;; CLJS source code path
                        :source-paths ["src/cljs"]

                ;; Google Closure (CLS) options configuration
                        :compiler     {;; CLS generated JS script filename
                                       :output-to     "resources/public/js/modern.js"

                           ;; minimal JS optimization directive
                                       :optimizations :whitespace

                           ;; generated JS code prettyfication
                                       :pretty-print  true}}]}
  ;; to clean JS files generated during the build
  :clean-targets ^{:protect false} [:target-path "resources/public/js/"]
  ;; :repl-options {:init-ns modern-cljs.core}
  )

