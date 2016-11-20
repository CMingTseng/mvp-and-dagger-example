# MVP and Dagger Example

I recently had to get experience with MVP and Dagger very quickly, since I acquired a new job.

This sample provides a simple example of how Dagger and MVP can be used on Android. The main benefit
of MVP is predictability and test-ability.

### Explanations

**I have comments on classes and various places in the code**, rather than providing a long tutorial here.
However, here is a basic flow chart of how MVP is working here (*note that this sample project doesn't
fully match this chart, the sample is a bit simpler*):

<br/>
<img src="https://github.com/afollestad/mvp-and-dagger-example/raw/master/mvpchart.png" />

*And of course, "server" above could be replaced with any type of data source, such as a local database.*