(defproject commander "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [seesaw "1.4.4"]]
  :javac-options ["-target" "1.6" "-source" "1.6" "-Xlint:-options"]
  :aot [commander.core]
  :main commander.core)
