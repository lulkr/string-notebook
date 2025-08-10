//
//  StringNotebookApp.swift
//  App
//
//  Created by Just Burrow on 2025/06/04.
//
import SwiftUI
import SharedKit

@main
struct StringNotebookApp: App {
    init() {
        Configuration.shared.initialize()
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
