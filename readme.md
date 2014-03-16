# Improved FormSender add-on for Vaadin 6

This is a fork of [FormSender](https://github.com/ripla/Formsender), a simple add-on that enables you to perform HTTP POST requests on the client-side.  See [the Directory](http://vaadin.com/addon/formsender) for more info.

### Improvements

This fork adds the ability to set the form target (e.g. `_blank`) and form action via
* `FormSender.setFormTarget(...)`
* `FormSender.setFormAction(...)`

### Licence

[Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0)

### Authors

* [Risto Yrjänä](https://github.com/ripla) - original author of the [FormSender add-on](https://github.com/ripla/Formsender)
* [Stefan Endrullis](https://github.com/xylo) - author of the improvements mentioned above

### Build the add-on

To build the add-on from source run `mvn package`.

### Run the demo

To test, clone the repo, run `mvn pakcage jetty:run` and browse to [http://localhost:8080/formsender/app](http://localhost:8080/formsender/app). From there you can do a HTTP POST to either the app itself or a separate JSP page.
