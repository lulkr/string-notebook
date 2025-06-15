//
//  ComposeView.swift
//  App
//
//  Created by Just Burrow on 2025/06/04.
//
import Foundation
import SharedKit
import SwiftUI
import os

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        return ComposeControllerKt.ComposeController()
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
    }
}
