(ns index
  (:require [tablecloth.api :as tc]
            [tc-profiling.api :as tp]))

(tp/html [:h1 "Titanic dataset"])

;; See [colab][colab]
;;
;; [colab]: https://colab.research.google.com/github/ydataai/pandas-profiling/blob/master/examples/titanic/titanic_cloud.ipynb

(def ds (tc/dataset "https://raw.githubusercontent.com/datasciencedojo/datasets/master/titanic.csv"))

(-> ds
    (tp/info :profile)) ;; for now just pass through

;; TODO replicate the IPYNB view using Tablecloth
