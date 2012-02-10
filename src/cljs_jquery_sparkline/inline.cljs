(ns cljs-jquery-sparkline.inline
  (:require 
    [cljs-jquery.inline :as _jquery]
    [wrap-js.core :as wrap-js])
  (:require-macros [wrap-js.macros.file-contents :as mfc])
  )

(def plugin-src (mfc/from-local-file "js/jquery.sparkline.min.js"))
(wrap-js/add-inline! plugin-src)

