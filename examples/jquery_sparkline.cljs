(ns examples.jquery-sparkline
  (:require  
    [clojure.browser.repl :as repl]
    [cljs-jquery-sparkline.inline :as _sl]
    
    [goog.dom :as gdom]
    [piccup.html :as ph]
    )
  )


(defn log-str 
  ([x]   (do (.log js/console (pr-str x)) x))
  ([m x] (do (log-str {:msg m :data x})   x)))


(defn log 
  ([x]   (do (.log js/console x) x))
  ([m x] (do (log {:msg m :data x})   x)))

(defn clj->js
  "Convert clj to js"
  [clj-obj]
  (cond 
    (map? clj-obj) 
    (let [out (js-obj)]
      (doseq [[k v] clj-obj]
        (aset out (name k) (clj->js v)))
      out)
      
    (sequential? clj-obj)
    (.-array (vec (map clj->js clj-obj)))
    
    :else
    clj-obj
    ))

(def $ js/jQuery)


;(repl/connect "http://localhost:9000/repl")

;; example taken from
;;  http://omnipotent.net/jquery.sparkline/

(def h 
  [:div
   [:p "Inline Sparkline:  "             [:span.inlinesparkline "1,4,4,7,5,9,10"]]
   [:p "Sparkline with dynamic data:  "  [:span.dynamicsparkline "Loading..."]]
   [:p "Bar chart with dynamic data:  "  [:span.dynamicbar "Loading..."]]
   [:p "Bar chart with inline data:  "   [:span.inlinebar "1,3,4,5,3,5"]]
   ]
  )

(gdom/append (.-body js/document) (first (ph/html h)))

(defn apply-sparks []
  (do
    ;; This code runs when everything has been loaded on the page
    ;;  Inline sparklines take their values from the contents of the tag
    (.sparkline ( $ ".inlinesparkline"))
    
    ;; Sparklines can also take their values from the first argument 
    ;; passed to the sparkline() function
    
    (let [myvalues (clj->js [10 8 5 7 4 4 1]) ]
      (.sparkline ($ ".dynamicsparkline") myvalues)
      
      ;; The second argument gives options such as chart type
      (.sparkline ($ ".dynamicbar") myvalues (clj->js {:type "bar" :barColor "green"})) 
      ) 
        
    ;; Use 'html' instead of an array of values to pass options 
    ;; to a sparkline with data in the tag 
    (.sparkline ($ ".inlinebar") "html" (clj->js {:type "bar" :barColor "red"})) 
    )   
  )
        
(apply-sparks)

    