# AgileAnalyzer
Test task for AgileEngine.

***

 ##### How to run the program:

Executed jar file and test samples are stored in /sample directory

To start application use the following console command:
  
```java -jar html-parser-1.0-SNAPSHOT.jar <path_to_the_origin_html_file>> <path_to_the_sample_html_file> <target_elememt_id>```

 ##### Test samples:

```
for all test cases you can use:
 
path_to_the_origin_html_file = sample-0-origin.html

target_elememt_id = make-everything-ok-button 
``` 
 
  
 sample-1-evil-gemini.html
 ```
[INFO] 2019-03-13 23:08:11 c.a.t.Analyzer - Original file - sample-0-origin.html.
[INFO] 2019-03-13 23:08:11 c.a.t.Analyzer - Sample file - sample-1-evil-gemini.html.
[INFO] 2019-03-13 23:08:12 c.a.t.Analyzer - Found element in original file: <a id="make-everything-ok-button" class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okDone(); return false;"> Make everything OK </a>.
[INFO] 2019-03-13 23:08:12 c.a.t.Analyzer - The best matching element - <a class="btn btn-success" href="#check-and-ok" title="Make-Button" rel="done" onclick="javascript:window.okDone(); return false;"> Make everything OK </a>
[INFO] 2019-03-13 23:08:12 c.a.t.Analyzer - Number of matches - 3
[INFO] 2019-03-13 23:08:12 c.a.t.Analyzer - Path to the best matching element - a>div>div>div>div>div>div>body>html 
``` 
 
 sample-2-container-and-clone.html
 ```
[INFO] 2019-03-13 23:14:41 c.a.t.Analyzer - Original file - sample-0-origin.html.
[INFO] 2019-03-13 23:14:41 c.a.t.Analyzer - Sample file - sample-2-container-and-clone.html.
[INFO] 2019-03-13 23:14:41 c.a.t.Analyzer - Found element in original file: <a id="make-everything-ok-button" class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okDone(); return false;"> Make everything OK </a>.
[INFO] 2019-03-13 23:14:41 c.a.t.Analyzer - The best matching element - <a class="btn test-link-ok" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okComplete(); return false;"> Make everything OK </a>
[INFO] 2019-03-13 23:14:41 c.a.t.Analyzer - Number of matches - 3
[INFO] 2019-03-13 23:14:41 c.a.t.Analyzer - Path to the best matching element - a>div>div>div>div>div>div>div>body>html 
``` 
 
 sample-3-the-escape.html
 ```
 [INFO] 2019-03-13 23:16:33 c.a.t.Analyzer - Original file - sample-0-origin.html.
 [INFO] 2019-03-13 23:16:33 c.a.t.Analyzer - Sample file - sample-3-the-escape.html.
 [INFO] 2019-03-13 23:16:33 c.a.t.Analyzer - Found element in original file: <a id="make-everything-ok-button" class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okDone(); return false;"> Make everything OK </a>.
 [INFO] 2019-03-13 23:16:33 c.a.t.Analyzer - The best matching element - <a class="btn btn-success" href="#ok" title="Do-Link" rel="next" onclick="javascript:window.okDone(); return false;"> Do anything perfect </a>
 [INFO] 2019-03-13 23:16:33 c.a.t.Analyzer - Number of matches - 4
 [INFO] 2019-03-13 23:16:33 c.a.t.Analyzer - Path to the best matching element - a>div>div>div>div>div>div>body>htmlv->div->div->div->div->body->html
 ``` 
 
 sample-4-the-mash.html
 ```
 [INFO] 2019-03-13 23:17:58 c.a.t.Analyzer - Original file - sample-0-origin.html.
 [INFO] 2019-03-13 23:17:58 c.a.t.Analyzer - Sample file - sample-4-the-mash.html.
 [INFO] 2019-03-13 23:17:58 c.a.t.Analyzer - Found element in original file: <a id="make-everything-ok-button" class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okDone(); return false;"> Make everything OK </a>.
 [INFO] 2019-03-13 23:17:58 c.a.t.Analyzer - The best matching element - <a class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okFinalize(); return false;"> Do all GREAT </a>
 [INFO] 2019-03-13 23:17:58 c.a.t.Analyzer - Number of matches - 4
 [INFO] 2019-03-13 23:17:58 c.a.t.Analyzer - Path to the best matching element - a>div>div>div>div>div>div>body>html
 ``` 
