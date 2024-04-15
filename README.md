# Tablecloth Profiling

Aims to provide similar functionality to [ydata][ydata], but for the emerging
Clojure data stack.

[ydata]: https://github.com/ydataai/ydata-profiling

## Usage

FIXME: write usage documentation!

Invoke a library API function from the command-line:

    $ clojure -X tc-profiling.tc-profiling/foo :a 1 :b '"two"'
    {:a 1, :b "two"} "Hello, World!"

Run the project's tests (they'll fail until you edit them):

    $ clojure -T:build test

Run the project's CI pipeline and build a JAR (this will fail until you edit the tests to pass):

    $ clojure -T:build ci

This will produce an updated `pom.xml` file with synchronized dependencies inside the `META-INF`
directory inside `target/classes` and the JAR in `target`. You can update the version (and SCM tag)
information in generated `pom.xml` by updating `build.clj`.

Install it locally (requires the `ci` task be run first):

    $ clojure -T:build install

Deploy it to Clojars -- needs `CLOJARS_USERNAME` and `CLOJARS_PASSWORD` environment
variables (requires the `ci` task be run first):

    $ clojure -T:build deploy

Your library will be deployed to net.clojars.tc-profiling/tc-profiling on clojars.org by default.

## License

Copyright © 2024 Kyle S Passarelli

Distributed under the Eclipse Public License version 1.0.
