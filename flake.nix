{
  description = "A Kotlin development environment";

  outputs = { self, nixpkgs }:

    let pkgs = import nixpkgs { system = "x86_64-darwin"; };
    in
    {
      devShells.x86_64-darwin.default = pkgs.mkShell {
        name = "kotlin";
        buildInputs = [ pkgs.kotlin pkgs.gradle ];
      };
    };
}
