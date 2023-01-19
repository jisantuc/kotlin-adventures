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

Everything will go much more easily if you install [`nix`] and enable [flakes] -- you can
then run `nix develop` to get exactly the same development shell that I have. However,
if you don't want to, you can also run the examples as long as you have a `kotlin`
compiler and a JDK somewhere on your path.

[`adt`]: https://github.com/jisantuc/kotlin-adventures/tree/adt
[`thunking`]: https://github.com/jisantuc/kotlin-adventures/tree/thunking
[`nix`]: https://nix.dev/tutorials/install-nix
[flakes]: https://nixos.wiki/wiki/Flakes
