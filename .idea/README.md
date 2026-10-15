# `.idea/`

This folder contains IntelliJ IDEA project configuration and editor settings.
These files help the IDE present and configure the project; they are
development tooling, not production code, an application layer, or part of
the runtime request path.

The Java production and test source roots are configured in
[`noWayToHide.iml`](../noWayToHide.iml), not established by the presence of
this directory. Keep Java application classes under [`src/`](../src/README.md)
and automated tests under [`test/`](../test/README.md).

Commit shared project settings only when they help contributors use the
project consistently. Avoid committing personal workspace state or
machine-specific configuration unless the team deliberately chooses to share
it.
