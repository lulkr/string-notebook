//
//  ComposeView.swift
//  App
//
//  Created by Just Burrow on 2025/06/04.
//
import Foundation
import SharedKit
import SwiftUI

struct ComposeView: UIViewControllerRepresentable {
    private let logger = LoggerFactory.shared.logger(name: "ComposeView")
    
    func makeUIViewController(context: Context) -> UIViewController {
        logger.d(message: "#makeUIViewController args : context=\(context)", e: nil)
        return ComposeControllerKt.ComposeController()
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        logger.d(message: "#updateUIViewController args : uiViewController=\(uiViewController), context=\(context)", e: nil)
    }
}