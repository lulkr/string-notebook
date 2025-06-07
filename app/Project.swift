import ProjectDescription

let project = Project(
    name: "String Notebook App",
    targets: [
        .target(
            name: "App",
            destinations: .iOS,
            product: .app,
            bundleId: "kr.lul.stringnotebook.App",
            infoPlist: .extendingDefault(
                with: [
                    "CFBundleDisplayName": "String Notebook",
                    "UILaunchScreen": [
                        "UIColorName": "",
                        "UIImageName": "",
                    ],
                    "CADisableMinimumFrameDurationOnPhone": true
                ]
            ),
            sources: ["src/iosMain/Source/**"],
            resources: [],
            scripts: [
                .pre(
                    script: """
                    cd "$(git rev-parse --show-toplevel)"
                    
                    ./gradlew :shared:embedAndSignAppleFrameworkForXcode
                    """,
                    name: "Build KMP"
                )
            ],
            dependencies: []
        )
    ]
)