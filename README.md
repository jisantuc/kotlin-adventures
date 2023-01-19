# `kotlin-adventures`

This repo contains a small multi-project Kotlin app. My goals are to explore:

- concurrency via coroutines
- java interoperability
- testing
- algebraic data modeling

and to understand how these facilities in Kotlin relate to similar facilities
in the TypeLevel Scala ecosystem.

## Organization

Explorations will live on branches.

Some branches that exist right now are:

- [`thunking`]: coroutine-based concurrency with Java interop
- [`adt`]: algebraic data types

For any specific branch, you can inspect `Main.java` to see what runs are interesting
for that exploration, and run it with `./gradlew :app:run`.

[`adt`]: https://github.com/jisantuc/kotlin-adventures/tree/adt
[`thunkings`]: https://github.com/jisantuc/kotlin-adventures/tree/thunking
